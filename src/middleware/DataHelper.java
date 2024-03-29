package middleware;
import java.util.*;
import tool.*;

/**文件信息辅助
*在读取文件时，记录文件头的一些临时信息
*如：标识、版本号、单元数量、偏移、异常标识
*/

public class DataHelper
{

    // 标识符
	private char[] identifier;
    //版本号
	private int version;
    //单元数量
	private int elementNum;
    //单元类型
    private char type;

	public DataHelper(){
		identifier=new char[2];
	}

	public char[] getIdentifier()
	{
		return identifier;
	}
	public int getVersion()
	{
		return version;
	}
	public int getElementNum()
	{
		return elementNum;
	}
	
	public void setData(char[] data){
		identifier[0]= data[0];
		identifier[1]= data[1];
		version=data[2];
		elementNum=SixtyToTen.sixtyToTen(String.valueOf(new char[]{data[3],data[4]}));
		type=data[5];
	}

	
	
}
