package com.grammar.serialization;

import com.bean.Person;

import java.io.*;
import java.text.MessageFormat;
import java.time.LocalDate;

/**
 * 测试对象的序列化和反序列
 *
 * @author chenjun
 * @date 2018/9/28
 * @since V1.0.0
 */
public class TestObjSerializeAndDeserialize {

    public static void main(String[] args) throws Exception {
        //序列化Person对象
        SerializePerson();

        //反序列Perons对象
        Person p = DeserializePerson();
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",
                p.getName(), p.getBirthday().toString(), p.getGender().name()));
    }

    /**
     * MethodName: SerializePerson
     * Description: 序列化Person对象
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("chen");
        person.setBirthday(LocalDate.of(2017, 12, 25));
        person.setGender(Person.Sex.FEMALE);

        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/www/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson
     * Description: 反序列Perons对象
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/www/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}
