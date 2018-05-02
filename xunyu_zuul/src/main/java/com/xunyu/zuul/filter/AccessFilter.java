package com.xunyu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关拦截
 */
public class AccessFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true;   //决定是否走该过滤器
    }

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     *pre：可以在请求被路由之前调用
     *routing：在路由请求时候被调用
     *post：在routing和error过滤器之后被调用
     *error：处理请求时发生错误时被调用
     *filterOrder：通过int值来定义过滤器的执行顺序
     *shouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效。
     *run：过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，当然我们也可以进一步优化我们的返回，比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
     *filterOrder：返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
     *shouldFilter：返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行。
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String url = request.getRequestURI();
        if(StringUtils.isNotEmpty(url) && url.indexOf("shiro") >= 0) {
            //如果包含shiro开头的请求，直接放行
            return null;
        }else{
            Object accessToken = request.getParameter("sessionId");  //定义规则：访问url中必须带有sessionId参数
            if (accessToken == null) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(404);
                ctx.setResponseBody("请传入sessionId");
                return null;
            }
        }
        return null;

    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


}

