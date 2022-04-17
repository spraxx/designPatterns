package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.Map;

public class APIMoodle implements APIServiceInterface{
    protected java.util.LinkedHashMap<String,String> content = new LinkedHashMap<>();
    int count = 0;
    public APIMoodle()
    {

    }
    public String getContent(String contentId)
    {
        if(!contentId.equals("0"))
        {
            return this.content.get(contentId);
        }
        String res = "";
        for(Map.Entry<String,String> entry : this.content.entrySet())
        {
            res = res.concat(entry.getValue());
        }
        return res;
    }

    public String setContent(String content)
    {
        String contentID = "content ID " + count;
        this.content.put(contentID, content);
        count ++;
        return contentID;
    }

}
