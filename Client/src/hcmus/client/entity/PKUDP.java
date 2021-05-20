/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcmus.client.entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author long
 */
public class PKUDP {

    // public int index;
    // 63 max bytes
    public static final int BUFFERDATA = 8 + FileReader.BUFFER;

    public static byte[] getPacket(long index, List<Byte> bytes) {
        List<Byte> bindex = Arrays.asList(SObject.getBytesFromLong(index));
        LinkedList<Byte> fragmentList = new LinkedList() {
            {
                addAll(bindex);
                addAll(bytes);
            }
        };
        return SObject.convertByteTobyte(fragmentList.toArray(new Byte[0]));
    }

    public static byte[] getPacket(long index, byte[] bytes) {
        return getPacket(index, Arrays.asList(SObject.convertbyteToByte(bytes)));
    }
}
