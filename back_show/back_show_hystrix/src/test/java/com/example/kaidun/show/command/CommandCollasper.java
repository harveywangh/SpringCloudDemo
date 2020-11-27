package com.example.kaidun.show.command;

import com.netflix.hystrix.*;
import lombok.Data;
import org.assertj.core.util.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Harvey
 * @date: 2020/11/25 13:57
 * @description:请求合并处理对象
 */
@Data
public class CommandCollasper extends HystrixCollapser<List<String>, String, Integer> {

    private Integer id;

    public CommandCollasper(Integer id) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("CommandCollasper"))
        .andCollapserPropertiesDefaults(HystrixCollapserProperties.defaultSetter()
        .withTimerDelayInMilliseconds(10))
        );
        this.id = id;
    }

    //获取请求参数
    @Override
    public Integer getRequestArgument() {
        return id;
    }

    //批量业务处理
    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
        return new BatchCommand(collapsedRequests);
    }

    //批量处理结果与请求业务间映射关系处理
    @Override
    protected void mapResponseToRequests(List<String> batchResponse, Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
        int counts = 0;
        Iterator<CollapsedRequest<String, Integer>> iterator = collapsedRequests.iterator();

        while (iterator.hasNext()) {
            CollapsedRequest<String, Integer> response = iterator.next();
            String result = batchResponse.get(counts++);
            response.setResponse(result);

        }
    }


    class BatchCommand extends HystrixCommand<List<String>> {
        private Collection<CollapsedRequest<String, Integer>> collapsedRequests;

        public BatchCommand(Collection<CollapsedRequest<String, Integer>> collapsedRequests) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("BatchCommand")));
            this.collapsedRequests = collapsedRequests;
        }

        @Override
        protected List<String> run() throws Exception {
            System.err.println("current Thread : " + Thread.currentThread().getName());
            List<String> result = Lists.newArrayList();

            Iterator<CollapsedRequest<String, Integer>> iterator = collapsedRequests.iterator();

            while (iterator.hasNext()) {
                CollapsedRequest<String, Integer> request = iterator.next();

                Integer reqParam = request.getArgument();
                //具体业务逻辑
                result.add("HHHH req" + reqParam);

            }
            return result;
        }
    }


}
