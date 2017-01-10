package ru.stqa.javaCursBarancev.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;
import static org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.file;

/**
 * Created by yafar_000 on 08.01.2017.
 */
public class KontactDataGenerator {

  @Parameter(names = "-c", description = "Kontact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    KontactDataGenerator generator = new KontactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
   }

  private void run() throws IOException {
    List<KontactData> kontacts = generateKontacts(count);
    if (format.equals("csv")){
      saveAsCsv(kontacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(kontacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(kontacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<KontactData> kontacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(kontacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXml(List<KontactData> kontacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    String xml = xstream.toXML(kontacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private static void saveAsCsv(List<KontactData> kontacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)){
      for (KontactData kontact : kontacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                kontact.getFirstname(),
                kontact.getMiddlename(),
                kontact.getLastname(),
                kontact.getNickname(),
                kontact.getCompany(),
                kontact.getTitle(),
                kontact.getAddress(),
                kontact.getHomePhone(),
                kontact.getMobilePhone(),
                kontact.getWorkPhone(),
                kontact.getEmail(),
                kontact.getEmail2(),
                kontact.getEmail3(),
                kontact.getAddress2()));
      }
    }
  }

  private static List<KontactData> generateKontacts(int count) {
    List<KontactData> kontacts = new ArrayList<KontactData>();
    for (int i = 0; i < count; i++) {
      kontacts.add(new KontactData()
              .withFirstname(format("first_name %s", i))
              .withMiddlename(format("middlename %s", i))
              .withLastname(format("last_name %s", i))
              .withNickname(format("nickname %s", i))
              .withCompany(format("company %s", i))
              .withTitle(format("title %s", i))
              .withAddress(format("address %s", i))
              .withHomePhone(format("(8-333)33-33-33 %s", i))
              .withMobile(format("+79999999999 %s", i))
              .withWorkPhone(format("22 22 22 %s", i))
              .withEmail(format("email@mail.mail %s", i))
              .withEmail2(format("email2@mail.mail %s", i))
              .withEmail3(format("email3@mail.mail %s", i))
              .withAddress2(format("address2 %s", i)));
    }
    return kontacts;
  }
}
