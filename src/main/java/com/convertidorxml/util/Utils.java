/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.convertidorxml.util;

import java.net.MalformedURLException;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author yovanotti
 */
public class Utils {
    
    public static void main(String[] args) {
        String foto = "/9j/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB"
                    + "AQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQE"
                    + "BAQH/wAARCAA8ADwDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAw"
                    + "UFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RF"
                    + "RkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMX"
                    + "Gx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAw"
                    + "QFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNO"
                    + "El8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJma"
                    + "oqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD"
                    + "+/CiiigAooqOWVIUMkjBFUZJJx0+tAEhOOtfP/wC0P+1H8Cf2VPh1rXxW+PfxE0L4d+BNAiLX2tazO2Zrg8QabpVhbrNqGs"
                + "6xeviOy0nS7a6v7qQ4ihIDMv5qf8FR/wDgtR+zf/wTn8M3mhahfRfEn486np7z+Ffg54c1BI9V3SKn2fVfGeqLb3dv4P8AD/7"
                + "zzVnvY5NT1JEZNJ0+5+aaL/N9/bq/4KIftJ/t+fE2X4h/HfxlLqcNpPcDwh4B0l3sfAfw/wBPnKL9i8P6Op2rcNGifbdZvzda3q"
                + "jjfdXnl7IY+ilQlO0pXjDfbWXp5f3vuuHof6Dn7AH/AAcNfs1/t3/tY+Jf2YtL8D+Jvhg+uzXh/Z+8T+Kr61nf4pQ6Fpd1qWvWO"
                + "u6ZbwRDwX4kuLayutT8O6M13q0d/p0EtrcX9vrAjspv6EQc9K/xbv2fvAHxO8W+NfDNz8O/+EjtPEH9v2EfhrV/DIvB4nl8RQ"
                + "3MJsYPBMGnyRanea/bzyQTW66U6zWZxdSyxRxO6/62H/BOuL9rWD9kf4WRfts3mnXfx6i0+4i1ia2s7aDWm8PRSCPwufG7abe3"
                + "Gl3PjttKSOTxPd6ctrBNev8AvrYXy3c03bjMtq4fC4fGyjCjSxEuSjTnUSrV4xTbxNOjKTqvD3XI6zSpyqaU5S95R56deE61Sh"
                + "GTqOmuacow/d022kqTmvcdT7XInzRj8SWjf3DRTXdUUsxwB/nvXx9+15+238Av2MPhhq3xS+OXjvTPCHh+ySWOwglLXeu+JNSQ"
                + "KY9G8LaHbB9Q1rVpmdALe1iMdujfaL2e1tkkmXy0m2kk23skdB9R+IfE+i+GNMvdW1rUbPTrDT7aa8vby9uIrW0s7S3jMtxdX"
                + "VzOyQW9vBGrSTTzOkUSKzyMqg1/H5/wU4/4OG9X1fxBrf7M/wDwTgiTxt43kN3pniX48pbxT+GvDiRiMXreAodTtxp+oyWai"
                + "4S58a6w0fh/TmjMumwaiwju0/Iv9v7/AIK2ftJ/8FKT4ksdK1q4/Zk/Yg0jUDa3z3N4H1bxusLq0UOvXNolpe+L9duGh8y2"
                + "8E6G/wDYOlM4fVJrt4vtw/Gp/FF946sbv4cfAzSLrwN8L/tMFl4m8V35a68UeOLstugGv3tuoub67u2Vn03wVoJ+yW6sGuB"
                + "JFFLqCelhcDKpOEXGVSrOSjTowjzylJtWUYxu5t9krJ7817EykopylJRjFXlKTskl1bdkl3bMn4o+LbDT/Emt6vqfiOb4+"
                + "/HvxJd3WoeK/HutTXHiLw9o2rT7nvG0ptRaaTxjrce4mfxDqqnSbRoh/ZthLHGl2Oa8B/sx+KtUh03xv47tho3hLUZ7m8X"
                + "7VL9nutXS3Mkl2sJSOWOGUHbMsN59leaB/PhjktlkdP07/Y5/YvuvE2meL/Hlh4W0+H4d/D/QrzV/E/xM8aanDofh6w13"
                + "SG+0W+iT6ldA2XiTxPq00LaXpXgrRi9hYX13Yz3dzqF7JZzyf0A/sB/8EffH/wC1xqnhL40ftR6HffDX9m/TZ7bVvDXwr"
                + "vLf7H40+L8UczXNveeIBbXME3hDwpcTJbzvb2oF5qcSxxrNcIEu7f8AZsp4Z4KyHhzHcRcZZ/SrZ5SkqGU8HZeoYnFwxl4V"
                + "ITzhVEoqlKinLli1h6cZwk61evF4B/jud8W8f47jjKeFOEeD5rhlU1jeIuN84rPDZfLAThVp/VuH1h5ValbMKeKUVUhiYRr"
                + "v2c4PCYfB16ObHrn/AAbQ/sp/s8aj8MfFn7Tb/DvWb340+HPF2oeDNM8X6/pIsfA+kaNPbz3VnJ8I7B2/dvJpl0tp4j1C+i"
                + "k1G0vzJaW1wbaXzp/6z65bwX4J8IfDnwxpHgzwH4a0Xwh4U0C0Sx0bw94e0+30zSdNtU5EVrZ2sccSbmJeSQgyzSM0szySM"
                + "zHqa/Fs1x8szx+JxrjKmq9WUqdKVWdb2NPaFJVJ+84wilGK0UUlGKUUkfruGo/V6FKjdScIpSmoRhzy+1NxjonJ6vu9W2z8"
                + "Av8Agqn/AMFyfgX+wdpuofDvwi9n8Xf2kry38nSfhnod7I2n+Gbm4EP2W++IGr2cNyuloRMk1v4dtC/iDUsKhh0+3lW8r+"
                + "G/9qT4+fFL45+Mz+0H/wAFAvHOreLPGGpQteeAf2fdMvF0sadpkzCSzt9VsLJjb/D3wkEFtOulwwf8JFryr5946yyveN+nv"
                + "/BYn9ibxB+wP8e/F3xi+Evwmv8AxQ3x68X3uo+BPiNqDyeI9N+Gmv6rGtzrmhaVoN0t0sHii+v7i7vNI1zWJLqCGwJ/suKG"
                + "5tZ3tvxT8E/A/wAX3/im01vV/D+v/Gz4va/PNqsfh7RbafxZexSBi9xPaWUP2tvFWtqNzfbriOTw5pksTzL/AGvLCDD3Zdl"
                + "08VL9wo2jBVKuIrNU6GHpvlvOtUk1GEbu3LdznO0IxlKSiXUr06MVKd3JyUYwinOcpaNRhBK821urWSu5WSbXLf2L47+O9/"
                + "Y+LPipcL4W+H2jWJbwp4B0pY9EsbDw/HzHHp1hEi2/hnQHWMSXGsXVtPrGtt5k1nFeu0l/b/s1+yV+wjDqfh3wD8WPjdo+v"
                + "6B8HfHtnHa/BL4I+AtKjuvit+0RYPdbrlPA2jQXE+reGfB91cWyJqnjrUHs72/sp57y/wBSsoZ4Z7z8/fhp4N+Ofx7+MFh8"
                + "FPgR4N8Xar8TLrUrzS59At7C/tdVs5Lm0n07Wl8T/wBqQxJDFBHPLHqN1etC1ttZhPZwotw/9+f/AASL/wCCWkH7AfwqW8+"
                + "JWu2vj343+I0R7zVir3dl8OdCkM9yfh/4Lvbief7PoiaheXmp3402HT7G71S6uJVglGLiX6jFY3AcN4aVLLK9PF5rVtGtm"
                + "cUpunCzVSjgW3KFFpqPNioKo0nKNOSqKE6fkxp18xqqeKjOlhI3cMK7x9pJOPLKvazktZNUnyp2XOpQupXv2Of+Cel3Zwe"
                + "EvHn7SXhfwro2j+D4vN+CX7KPh2OPUfhh8E7eUzMmseI5t4tPiH8Tp4pt11ruqWUljokks1vo1vAQXH7FIixosaKFRFCIq"
                + "jCqqjCqoHAAAAAAAAGAMUoGOg/TH8qWvz+vXqYibqVHdtt2u2ld3bu225SfvTnJuc5NylJttnsRioK0VZKy0VtlZbaJJaJ"
                + "JJJaJJBRRRWJR4B+0X+zT8J/2pfhf4p+EPxf8N2/iLwZ4u0+TT9StS8lteW7PhodQ0y/gK3On6nYzLHcWV7buksEyA5ZGd"
                + "G+b/wBin/gmR+zB+wjoFxpfwg8MXWqeIdQj+yan8QvGlymu+Nr7TI2k+x6V/ackaR2Ol2UDpbR2WnQWsU4hSa78+U7l/Q+"
                + "itY1qsacqUak405tOUE/dk1s2tnZ7dhcqbUmlzK6Ttqk97Ppe2p5F4N+Avwa+H3jLxP8AETwX8MvBXhjx5418r/hLfF+ieH9"
                + "PsPEHiLyBtj/tXUoIUuLngDeGYeawV5d7qpHrtFFZuTlq229rtt6LZa9hhRRRSAKKKKAP/9k=";
        
        byte[] byteS = base64ToByte(foto);
        System.out.println("Strin again : "+ByteTobase64(byteS));
    }
    
    public static byte [] base64ToByte(String base64String){
       return Base64.decodeBase64(base64String);
    }
    
    public static String ByteTobase64(byte [] data){
       Base64 base64 = new Base64();  
       return base64.encodeBase64String(data);
    }
    
   
}
