package web.taglib;


import org.springframework.util.CollectionUtils;

/**
 * 自定义标签
 */
public class Functions {
    /**
     * 判断指定元素是否在给定集合中；
     * @param iterable
     * @param obj
     * @return
     */
    public static boolean in(Iterable iterable,Object obj){
        if(iterable == null){
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(),obj);
    }


}
