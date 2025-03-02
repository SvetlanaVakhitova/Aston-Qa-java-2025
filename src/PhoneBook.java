import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook extends HashMap<String, ArrayList<String>> {
  

    public void add(String name, String phone){

          // если запись для имени уже есть, создаём коллекцию, чтобы сохранить все, а не перезаписывать
        if(this.containsKey(name)) {
            ArrayList<String> existedList = this.get(name);
            existedList.add(phone);
            this.put(name, existedList);              
    }
    else{
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(phone);

        this.put(name, arrayList);
        }
    }

}
