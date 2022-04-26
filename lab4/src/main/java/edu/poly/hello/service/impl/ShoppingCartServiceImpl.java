package edu.poly.hello.service.impl;

import edu.poly.hello.model.CartItem;
import edu.poly.hello.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();  //Tạo map cho item trong cart


    @Override
    public void add(CartItem item){
        CartItem existedItem = map.get(item.getProductId()); //get productId rồi check xem có tồn tại hay không? (sẽ get được: id, name,quantity,price)

        System.out.println("value of item (before): " + item);
        if(existedItem != null) {   //nếu có thể get, chứng tỏ đang trùng lặp -> do đó ta cộng lên 1.
            //existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
            existedItem.setQuantity(existedItem.getQuantity() + 1);   // dùng cái này dễ hiểu hơn ( get số lượng hiện tại + 1)
        }else {
            map.put(item.getProductId(), item);

        }
        System.out.println("existedItem: "+ existedItem);
        System.out.println("value of item (after): " + item);

        if (existedItem == null){
            System.out.println("existedItem.getQuantity() is null nek: " );
        }else{
            System.out.println("existedItem.getQuantity(): " + existedItem.getQuantity());
        }
        System.out.println("existedItem sau cung : " + existedItem);

    }

/*
1. logic: Tại jst -> click add to cart -> PathVarialbe bắt sự kiện rồi lấy được productId.
2. Mang cái đó đi tìm trong class Product, nếu có thì xử lý tiếp
3. Tạo item để lưu cart item. dùng BeanUtils để copy thuộc tính(all) từ product sang item với id tương ứng.
4. Sau khi nhận được giá trị item rồi, thì ta tạo function existedItem(ở trên) có kiểu dữ liệu là CartItem, dùng để get id của product được add , ví dụ: 1,2,3,4
5. Nếu get được, chứng tỏ là existed id đó rồi.do vậy ta set quantity( số lượng) cho id đó ( bằng tổng quantity có trong cart + 1
*/
    @Override
    public void remove(int productId){
        map.remove(productId);
    }


    @Override
    public Collection<CartItem> getCartItems(){
        return map.values();  //tập hợp các giá trị(value trong key-value của hash
    }


    @Override
    public void clear(){
        map.clear();
    }

    @Override
    public void update(int productId, int quantity){
        CartItem item = map.get(productId);

        item.setQuantity(quantity ); //nếu add thì = số lượng + số lượng có sẵn
        if (item.getQuantity() <= 0){ // nếu số lượng nhỏ hơn hoặc bằng 0 thì remove
            map.remove(productId);
        }
        System.out.println("item value gia tri la: "+ item);
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
    }

    @Override
    public int getCount(){
        if(map.isEmpty())
            return 0;
        return  map.values().size();
    }
}
