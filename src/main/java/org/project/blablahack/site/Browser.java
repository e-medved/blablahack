package org.project.blablahack.site;

import org.project.blablahack.site.serf.SerfPolicy;

/**
 * Created by e.medvedev on 27.12.2016.
 *
 * to selenium serfing
 */
public class Browser<T extends SerfPolicy> {

  T serfPolicy;

  public Browser(T serfPolicy) {
    this.serfPolicy = serfPolicy;
  }

  public void startSerf(){
    this.serfPolicy.serf();
  }
}
