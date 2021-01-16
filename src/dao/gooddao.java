package dao;

import com.goods.web.goods;

import java.util.List;

public interface gooddao {

    List<goods> querygoods() throws Exception;

    int queryById(String good_id)throws Exception;
}
