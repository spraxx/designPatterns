package com.es2.bridge;


import java.util.HashMap;

public class APIRequest {
    protected java.util.HashMap<String,APIServiceInterface> services = new HashMap<>();
    int count = 0;
    public APIRequest()
    {

    }
    public String addService(APIServiceInterface service)
    {
        String serviceID = "Service ID " + count;
        this.services.put(serviceID, service);
        count ++;
        return serviceID;
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
    public java.lang.String setContent(java.lang.String serviceId, java.lang.String content) throws ServiceNotFoundException
    {
        APIServiceInterface api = services.get(serviceId);
        if (api == null)
        {
            throw new ServiceNotFoundException();
        }
        return api.setContent(content);

    }

}
