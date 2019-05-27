package preAndroid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.kitri.dto.Child;
import com.kitri.dto.Product;

public class SerializeTest {
	public static void main(String[] args) {
		/*
		 * file-name : a.ser 
		 * 바이트단위 출력스트림 : FileOutputStream
		 * 객체출력스트림 : ObjectOutputStream
		 */
//		직렬화
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("a.ser"));
			Date now = new Date();
			
			Product p = new Product();
			p.setProd_no("001");
			p.setProd_name("아메리카노");
			p.setProd_price(2500);
			
			Child c = new Child();
			c.setC("Child Instance Variable");
			
			oos.writeObject(now);
			oos.writeObject(p);//직렬화
			oos.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		/*
		 * file-name : a.ser
		 * ByteInputStream : FileInputStream
		 * ObjectInputStream
		*/
//		역직렬화
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("a.ser"));
			Object obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			System.out.println(obj);
			
			obj = ois.readObject();
			Child c1 = (Child)obj;
			System.out.println(c1.getC());
			System.out.println(c1.getP()); // Child Class에만 implements Serializable 하면 c1.getP는 null이 됨
										   // >> 자식테이블 부분만 직렬화 되었기 때문
										   // 부모쪽에 implements Serializable하면 부모,자식 모두 직렬화됨
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
