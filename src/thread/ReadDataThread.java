package thread;
import io.*;
import modle.*;
import middleware.*;
import java.util.*;
import org.json.*;
import adapter.*;
import java.io.*;

public class ReadDataThread implements Runnable
{

	private MindFileControl mfc;
	private ArrayList<JSONObject> jsArray;
	private ArrayList<WorkData> datas;
	private DataHelper dh;
	private FeatureAdapter adp=null;
	
	
	public ReadDataThread(MindFileControl mfc,ArrayList<WorkData> datas,DataHelper dh,FeatureAdapter adp){
		this.mfc=mfc;
		this.datas=datas;
		this.dh=dh;
		this.adp=adp;
		jsArray =new ArrayList<JSONObject>();
	}
	
	
	@Override
	public void run()
	{
		// TODO: Implement this method
		if(datas==null){
			return;
		}
		try
		{
			mfc.readFile( dh, jsArray);
			//使用适配器转换
			for(JSONObject jio:jsArray){
				datas.add(adp.toWorkData(jio));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
