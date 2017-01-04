package ru.stqa.javaCursBarancev.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yafar_000 on 04.01.2017.
 */
public class Kontacts extends ForwardingSet<KontactData> {

private Set<KontactData> delegate;

  public Kontacts(Kontacts kontacts) {
    this.delegate = new HashSet<KontactData>(kontacts.delegate);
  }

  public Kontacts() {
    this.delegate = new HashSet<KontactData>();
  }


  @Override
  protected Set<KontactData> delegate() {
    return delegate;
  }

  public Kontacts withAdded(KontactData kontact) {
    Kontacts kontacts = new Kontacts(this);
    kontacts.add(kontact);
    return kontacts;
  }

  public Kontacts withOut(KontactData kontact) {
    Kontacts kontacts = new Kontacts(this);
    kontacts.remove(kontact);
    return kontacts;
  }
}
