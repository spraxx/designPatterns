package com.es2.bridge;


public class APIRequestContentAggregator extends APIRequest{
   public APIRequestContentAggregator ()
    {

    }
    public java.lang.String getContent(java.lang.String serviceId, java.lang.String contentId) throws ServiceNotFoundException
    {
        APIServiceInterface api = services.get(serviceId);
        if (api == null)
        {
            throw new ServiceNotFoundException();
        }
        return api.getContent(contentId);

    }
}
