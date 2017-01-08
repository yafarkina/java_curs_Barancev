package ru.stqa.javaCursBarancev.addressbook.generators;

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

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<KontactData> kontacts = generateKontacts(count);
    save(kontacts, file);
  }

  private static void save(List<KontactData> kontacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (KontactData kontact : kontacts) {
     writer.write(String.format("%s;%s;%s\n", kontact.getFirstname(), kontact.getMiddlename(), kontact.getLastname()));
     }
    writer.close();
  }

  private static List<KontactData> generateKontacts(int count) {
    List<KontactData> kontacts = new ArrayList<KontactData>();
    for (int i = 0; i < count; i++) {
      kontacts.add(new KontactData()
              .withFirstname(format("first_name %s", i))
              .withMiddlename(format("middlename %s", i))
              .withLastname(format("last_name %s", i)));
    }
    return kontacts;
  }
}
