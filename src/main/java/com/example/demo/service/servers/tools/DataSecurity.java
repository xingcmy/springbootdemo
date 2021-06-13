package com.example.demo.service.servers.tools;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
@Log
public class DataSecurity {

    private static final int CHAR = 88;  /*string 数据为english 添加的数据data数组长度*/
    private static final int ALL = 176; //data数组长度
    private int[] TYPE_CODE = new int[2];
    private static final int TYPE_CODE_0 = 0; //type code数组下标
    private static final int TYPE_CODE_1 = 1;
    private int code = SendIDTool.random(0,3);   /*code为0~3的随机数*/
    private static final int CODE = 2;   /* data增加倍数*/
    private static final int CODE_0 = 0;
    private static final int CODE_1 = 1;
    private static final int CODE_2 = 2;
    private static final int CODE_3 = 3;
    private int type = 0;
    private Integer size = -1;  /*数据长度*/
    private static final String[] DATA = new String[]{".","0","1","2","3","4","5","6","7","8","9","q","w","e","r","t","y","u","i","o","p","a","s",
            "d","f","g","h","j","k","l","z","x","c","v","b","n","m","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O",
            "P","Q","R","S","T","U","V","W","X","Y","Z","<",">","?",":","{","}","~","!","@","#","$","%","^","&","*","(",")","_",
            "+",",","/","|","[","]","`","你","我","他","她","它","好","的","得","地","时","间","球","在","哪","里","有","由","幼","游",
            "星","新","心","信","芯","啊","阿","吖","嗄","吧","并","从","辰","想","才","向","白","百","拜","摆","上","三","说","吗","码",
            "霂","名","对","等","人","如","让","图","头","与","用","以","片","萍","票","跑","盘","发","分","方","否","个","给","过","改",
            "该","号","就","将","及","讲","十","看","空","可","库","了","类","楼","来","值","再","这","哦"};
    private String[] DATA_ONE;
    private String[] DATA_TWO;
    private String[] DATA_THREE;
    private String[] DATA_FOUR;

    private Map<String,Object> objectMap = new HashMap<>();

    private static final Unsafe unsafe;
    private static final long offset;

    @Autowired
    private DataSecurity dataSecurity;

    @Autowired
    private Star star;

    static {
        try {
            unsafe=getUnsafe();
            Class<?> s= DataSecurity.class;
            offset=unsafe.objectFieldOffset(s.getDeclaredField("size"));
        }catch (Exception e){
            throw new Error(e);
        }

    }

    private static Unsafe getUnsafe() {
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        }catch (Exception e){
            return null;
        }
    }

    public boolean casInt(int var1,int var2){
        return unsafe.compareAndSwapInt(this,offset,var1,var2);
    }

    public boolean casObject(Object var1,Object var2){
        return unsafe.compareAndSwapObject(this,offset,var1,var2);
    }

    private int size(String data){
        return data.length();
    }
    public Map<String,Object> setData(String data){
        if (data == null)
            return null;
        for (;;){
            this.size=size(data);
            synchronized (size){
                return setMap(data);
            }
        }
    }

    public String getData(String data,int code,int[] typeCode){
        if (data == null)
            return null;
        this.TYPE_CODE = typeCode;
        return data(swapRestoreString(data,code+CODE));
    }

    private Map<String,Object> setMap(String data){
        int _code=this.code;
        objectMap.put(star.code,_code);
        switch (_code){
            case CODE_0:
                /**
                 * 不取2的倍数
                 */
                setTypeCode(_code+CODE);
                objectMap.put(star.key,TYPE_CODE);
                DATA_ONE=new String[this.size*(CODE_0+CODE)];
                DATA_ONE=_data(DATA_ONE,data,_code);
                DATA_ONE=dataSwapString(data(DATA_ONE),_code+CODE);
                objectMap.put(star.data,data(DATA_ONE));
                return objectMap;
            //break;
            case CODE_1:
                /**
                 * 不取3的倍数
                 */
                setTypeCode(_code+CODE);
                objectMap.put(star.key,TYPE_CODE);
                DATA_TWO=new String[this.size*(CODE_1+CODE)];
                DATA_TWO=_data(DATA_TWO,data,_code);
                DATA_TWO=dataSwapString(data(DATA_TWO),_code+CODE);
                objectMap.put(star.data,data(DATA_TWO));
                return objectMap;
            //break;
            case CODE_2:
                /**
                 * 不取4的倍数
                 */
                setTypeCode(_code+CODE);
                objectMap.put(star.key,TYPE_CODE);
                DATA_THREE=new String[this.size*(CODE_2+CODE)];
                DATA_THREE=_data(DATA_THREE,data,_code);
                DATA_THREE=dataSwapString(data(DATA_THREE),_code+CODE);
                objectMap.put(star.data,data(DATA_THREE));
                return objectMap;
            //break;
            case CODE_3:
                /**
                 * 不取5的倍数
                 */
                setTypeCode(_code+CODE);
                objectMap.put(star.key,TYPE_CODE);
                DATA_FOUR=new String[this.size*(CODE_3+CODE)];
                DATA_FOUR=_data(DATA_FOUR,data,_code);
                DATA_FOUR=dataSwapString(data(DATA_FOUR),_code+CODE);
                objectMap.put(star.data,data(DATA_FOUR));
                return objectMap;
            //break;
        }
        return null;
    }

    /**
     * 生成TypeCode
     * @param i
     */
    private void setTypeCode(int i){
        int num=0;
        for (;;){
            type= SendIDTool.random(1,9);
            if ( type % i != 0){
                TYPE_CODE[num]=type;
                num++;
            }
            if (num == CODE)
                return;
        }
    }

    /**
     * String[] to String
     * @param _data
     * @return
     */
    private String data(String[] _data){
        String data = "";
        for (String i : _data){
            data+=i;
        }
        return data;
    }

    /**
     * 数据加密
     * @param _DATA
     * @param data
     * @param _code
     * @return
     */
    private String[] _data(String[] _DATA,String data,int _code){
        if (data == null)
            return null;
        int i=0;
        for (String s : data.split("")){
            _DATA[i] = s;
            byte[] bytes=s.getBytes(StandardCharsets.UTF_8);

            if (bytes.length !=1 ){
                for (int j = 0;j < _code+1;j++){
                    i++;
                    _DATA[i]=DATA[SendIDTool.random(CHAR, ALL-1)];
                }
            }else {
                for (int j = 0;j < _code+1;j++){
                    i++;
                    _DATA[i]=DATA[SendIDTool.random(0,CHAR-1)];
                }
            }
            i++;
        }
        return _DATA;
    }

    /**
     * 数据替换
     * @param _data
     * @param _code
     * @return
     */
    private String[] dataSwapString(String _data,int _code){
        if (_data==null)
            return null;
        String[] data=_data.split("");
        boolean flog=true;
        for (int i = 0;i< this.size*_code;i++){
            if ( i%_code == 0){
                String flag=data[i];
                if (flog){
                    flog = false;
                    dataSwapNumber(_code, data, i, flag, TYPE_CODE_0);
                }else {
                    flog=true;
                    dataSwapNumber(_code, data, i, flag, TYPE_CODE_1);
                }
            }
        }
        return data;
    }

    private void dataSwapNumber(int _code, String[] data, int i, String flag, int typeCode0) {
        if ((i+TYPE_CODE[typeCode0]) > this.size*_code){
            int num=(i+TYPE_CODE[typeCode0])%(this.size*_code);
            data[i]=data[num];
            data[num]=flag;
        }else {
            data[i]=data[i+TYPE_CODE[typeCode0]];
            data[i+TYPE_CODE[typeCode0]]=flag;
        }
    }

    /**
     * 数据还原
     * @param _data
     * @param _code
     * @return
     */
    private String[] swapRestoreString(String _data,int _code){
        if (_data == null)
            return null;
        String[] data=_data.split("");
        this.size=size(_data);
        boolean isFlog=true;
        if ((this.size/_code)%2 == 0)
            isFlog=false;
        for (int i = this.size-1;i>=0;i--){
            if (i%_code==0){
                String flag=data[i];
                if (isFlog){
                    isFlog=false;
                    dataRestoreNumber(data, i, flag, TYPE_CODE_0);
                }else {
                    isFlog=true;
                    dataRestoreNumber(data, i, flag, TYPE_CODE_1);
                }
            }
        }
        return dataDecryption(data,_code);
    }

    private void dataRestoreNumber(String[] data, int i, String flag, int typeCode0) {
        if (this.size < (i+TYPE_CODE[typeCode0])){
            int num=(i+TYPE_CODE[typeCode0])%(this.size);
            data[i]=data[num];
            data[num]=flag;
        }else {
            data[i]=data[i+TYPE_CODE[typeCode0]];
            data[i+TYPE_CODE[typeCode0]]=flag;
        }
    }

    /**
     * 数据解密
     * @param data
     * @param code
     * @return
     */
    private String[] dataDecryption(String[] data,int code){
        if (data == null)
            return null;
        this.size=data.length;
        String[] _data = new String[this.size/code];
        for (int i = 0; i < this.size;i++){
            if (i%code != 0)
                continue;
            _data[i/code]=data[i];
        }
        return _data;
    }
}
