package movies.spring.data.neo4j.geohash;


/**
 * Created by libenrong on 2018/7/23.
 *
 * @Description: GeoHash实现经纬度的转化
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GeoHashUtil {

    private static final double MINLAT = -90;
    private static final double MAXLAT = 90;
    private static final double MINLNG = -180;
    private static final double MAXLNG = 180;
    public static final int HASH_LENGTH = 6;
    /**
     * 1 2500km;2 630km;3 78km;4 30km
     * 5 2.4km; 6 610m; 7 76m; 8 19m
     */

    private static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static HashMap<Character, Integer> CHARSMAP;

    static {
        CHARSMAP = new HashMap<Character, Integer>();
        for (int i = 0; i < CHARS.length; i++) {
            CHARSMAP.put(CHARS[i], i);
        }
    }

    /**
     * @param lat
     * @param lng
     * @return
     * @Author:lulei
     * @Description: 获取经纬度的base32字符串
     */
    public static String getGeoHashBase32(int hashLength, double lat, double lng) {
        boolean[] bools = getGeoBinary(hashLength, lat, lng);
        if (bools == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bools.length; i = i + 5) {
            boolean[] base32 = new boolean[5];
            for (int j = 0; j < 5; j++) {
                base32[j] = bools[i + j];
            }
            char cha = getBase32Char(base32);
            if (' ' == cha) {
                return null;
            }
            sb.append(cha);
        }
        return sb.toString();
    }


    /**
     * 求所在坐标点及周围点组成的九个
     * @param hashLength
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    public static List<String> getGeoHashBase32For9(int hashLength, double lat, double lng) {
        int latLength = 20; //纬度转化为二进制长度
        int lngLength = 20; //经度转化为二进制长度
        double minLat;//每格纬度的单位大小
        double minLng;//每个经度的倒下

        if (hashLength < 1) {
            return null;
        }
        latLength = (hashLength * 5) / 2;
        if (hashLength % 2 == 0) {
            lngLength = latLength;
        } else {
            lngLength = latLength + 1;
        }
        minLat = MAXLAT - MINLAT;
        for (int i = 0; i < latLength; i++) {
            minLat /= 2.0;
        }
        minLng = MAXLNG - MINLNG;
        for (int i = 0; i < lngLength; i++) {
            minLng /= 2.0;
        }


        double leftLat = lat - minLat;
        double rightLat = lat + minLat;
        double upLng = lng - minLng;
        double downLng = lng + minLng;
        List<String> base32For9 = new ArrayList<String>();
        //左侧从上到下 3个
        String leftUp = getGeoHashBase32(hashLength, leftLat, upLng);
        if (!(leftUp == null || "".equals(leftUp))) {
            base32For9.add(leftUp);
        }
        String leftMid = getGeoHashBase32(hashLength, leftLat, lng);
        if (!(leftMid == null || "".equals(leftMid))) {
            base32For9.add(leftMid);
        }
        String leftDown = getGeoHashBase32(hashLength, leftLat, downLng);
        if (!(leftDown == null || "".equals(leftDown))) {
            base32For9.add(leftDown);
        }
        //中间从上到下 3个
        String midUp = getGeoHashBase32(hashLength, lat, upLng);
        if (!(midUp == null || "".equals(midUp))) {
            base32For9.add(midUp);
        }
        String midMid = getGeoHashBase32(hashLength, lat, lng);
        if (!(midMid == null || "".equals(midMid))) {
            base32For9.add(midMid);
        }
        String midDown = getGeoHashBase32(hashLength, lat, downLng);
        if (!(midDown == null || "".equals(midDown))) {
            base32For9.add(midDown);
        }
        //右侧从上到下 3个
        String rightUp = getGeoHashBase32(hashLength, rightLat, upLng);
        if (!(rightUp == null || "".equals(rightUp))) {
            base32For9.add(rightUp);
        }
        String rightMid = getGeoHashBase32(hashLength, rightLat, lng);
        if (!(rightMid == null || "".equals(rightMid))) {
            base32For9.add(rightMid);
        }
        String rightDown = getGeoHashBase32(hashLength, rightLat, downLng);
        if (!(rightDown == null || "".equals(rightDown))) {
            base32For9.add(rightDown);
        }
        return base32For9;
    }

    /**
     * @param base32
     * @return
     * @Author:lulei
     * @Description: 将五位二进制转化为base32
     */
    private static char getBase32Char(boolean[] base32) {
        if (base32 == null || base32.length != 5) {
            return ' ';
        }
        int num = 0;
        for (boolean bool : base32) {
            num <<= 1;
            if (bool) {
                num += 1;
            }
        }
        return CHARS[num % CHARS.length];
    }

    /**
     * @param lat
     * @param lng
     * @return
     * @Author:lulei
     * @Description: 获取坐标的geo二进制字符串
     */
    private static boolean[] getGeoBinary(int hashLength, double lat, double lng) {
        int latLength = 20; //纬度转化为二进制长度
        int lngLength = 20; //经度转化为二进制长度
        double minLat;//每格纬度的单位大小
        double minLng;//每个经度的倒下

        if (hashLength < 1) {
            return null;
        }
        latLength = (hashLength * 5) / 2;
        if (hashLength % 2 == 0) {
            lngLength = latLength;
        } else {
            lngLength = latLength + 1;
        }
        minLat = MAXLAT - MINLAT;
        for (int i = 0; i < latLength; i++) {
            minLat /= 2.0;
        }
        minLng = MAXLNG - MINLNG;
        for (int i = 0; i < lngLength; i++) {
            minLng /= 2.0;
        }

        boolean[] latArray = getHashArray(lat, MINLAT, MAXLAT, latLength);
        boolean[] lngArray = getHashArray(lng, MINLNG, MAXLNG, lngLength);
        return merge(latArray, lngArray);
    }

    /**
     * @param latArray
     * @param lngArray
     * @return
     * @Author:lulei
     * @Description: 合并经纬度二进制
     */
    private static boolean[] merge(boolean[] latArray, boolean[] lngArray) {
        if (latArray == null || lngArray == null) {
            return null;
        }
        boolean[] result = new boolean[lngArray.length + latArray.length];
        Arrays.fill(result, false);
        for (int i = 0; i < lngArray.length; i++) {
            result[2 * i] = lngArray[i];
        }
        for (int i = 0; i < latArray.length; i++) {
            result[2 * i + 1] = latArray[i];
        }
        return result;
    }

    /**
     * @param value
     * @param min
     * @param max
     * @return
     * @Author:lulei
     * @Description: 将数字转化为geohash二进制字符串
     */
    private static boolean[] getHashArray(double value, double min, double max, int length) {
        if (value < min || value > max) {
            return null;
        }
        if (length < 1) {
            return null;
        }
        boolean[] result = new boolean[length];
        for (int i = 0; i < length; i++) {
            double mid = (min + max) / 2.0;
            if (value > mid) {
                result[i] = true;
                min = mid;
            } else {
                result[i] = false;
                max = mid;
            }
        }
        return result;
    }


    /**
     * @param geoHash
     * @return
     * @Author:lulei
     * @Description: 返回geoHash 对应的坐标
     */
    public static LatLng getMiddleLocation(String geoHash) {
        String geoHashBinaryStr = getGeoHashBinaryString(geoHash);
        if (geoHashBinaryStr == null) {
            return null;
        }
        StringBuffer lat = new StringBuffer();
        StringBuffer lng = new StringBuffer();
        for (int i = 0; i < geoHashBinaryStr.length(); i++) {
            if (i % 2 != 0) {
                lat.append(geoHashBinaryStr.charAt(i));
            } else {
                lng.append(geoHashBinaryStr.charAt(i));
            }
        }
        double latValue = getGeoHashMid(lat.toString(), MINLAT, MAXLAT);
        double lngValue = getGeoHashMid(lng.toString(), MINLNG, MAXLNG);
        LatLng location = new LatLng(latValue, lngValue);
        return location;
    }

    /**
     * 获取某经纬度对应网格的中心点
     * @param hashLength
     * @param lng
     * @param lat
     * @return
     */
    public static LatLng getMiddleLocation(int hashLength, double lng, double lat) {
        return getMiddleLocation(getGeoHashBase32(hashLength, lat, lng));
    }


    /**
     * @param geoHash
     * @return
     * @Author:lulei
     * @Description: 将geoHash转化为二进制字符串
     */
    private static String getGeoHashBinaryString(String geoHash) {
        if (geoHash == null || "".equals(geoHash)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < geoHash.length(); i++) {
            char c = geoHash.charAt(i);
            if (CHARSMAP.containsKey(c)) {
                String cStr = getBase32BinaryString(CHARSMAP.get(c));
                if (cStr != null) {
                    sb.append(cStr);
                }
            }
        }
        return sb.toString();
    }

    /**
     * @param binaryStr
     * @param min
     * @param max
     * @return
     * @Author:lulei
     * @Description: 返回二进制对应的中间值
     */
    private static double getGeoHashMid(String binaryStr, double min, double max) {
        if (binaryStr == null || binaryStr.length() < 1) {
            return (min + max) / 2.0;
        }
        if (binaryStr.charAt(0) == '1') {
            return getGeoHashMid(binaryStr.substring(1), (min + max) / 2.0, max);
        } else {
            return getGeoHashMid(binaryStr.substring(1), min, (min + max) / 2.0);
        }
    }


    /**
     * @param i
     * @return
     * @Author:lulei
     * @Description: 将数字转化为二进制字符串
     */
    private static String getBase32BinaryString(int i) {
        if (i < 0 || i > 31) {
            return null;
        }
        String str = Integer.toBinaryString(i + 32);
        return str.substring(1);
    }


    public static void main(String[] args) {
        String result = GeoHashUtil.getGeoHashBase32(HASH_LENGTH, 39.949547, 116.411497);
        List geoHashBase32For9 = GeoHashUtil.getGeoHashBase32For9(HASH_LENGTH, 39.928167, 116.389550);
        System.out.println(result);
        System.out.println(geoHashBase32For9);

        LatLng location = GeoHashUtil.getMiddleLocation(result);
        System.out.println(location.getLng() + ", " + location.getLat());
    }

}
