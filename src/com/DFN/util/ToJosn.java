package com.DFN.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.IOException;
import java.util.List;

public class ToJosn {

    public List JsonToClass(String json,Class entity) throws JsonParseException, JsonMappingException, IOException {
        JSONObject jsonObj=JSONObject.fromObject(json);
        System.out.println("JSON获取对象："+jsonObj.get("name"));
//两种方式均可
        List test=null;
 //       List test=(entity)JSONObject.toBean(jsonObj, entity);

   //     List test=mapper.readValue(json, entity);
        return test;
    }

    public String ClassToJson(Object test){
//两种方式均可
        return JSONSerializer.toJSON(test).toString();

 //      return JSONObject.fromObject(test).toString();
 //      return JSONArray.fromObject(test).toString();
    }

}
