package service.impl;

import com.goods.web.goods;
import dao.gooddao;
import dao.impl.*;
import service.goodservice;

import java.util.List;

public class goodserviceimpl implements goodservice {
    @Override
    public List<goods> querygoods() throws Exception {
        gooddao Gooddao = new gooddaoimpl();
        return Gooddao.querygoods();
    }
    @Override
    public int queryById(String good_id)throws Exception{
        gooddao Gooddao = new gooddaoimpl();
        return Gooddao.queryById(good_id);
    }
}
