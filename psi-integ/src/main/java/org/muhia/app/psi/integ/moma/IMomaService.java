package org.muhia.app.psi.integ.moma;

import org.muhia.app.psi.config.moma.properties.MomaProperties;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.integ.moma
  Generated on: 12-Mar-17, 17:19.
 */
public interface IMomaService {
    String urlSubstitution(String url, MomaProperties mp, String retrievalPrefix, String retrievalMethod);
//    void  logMomaRegistryMetaData(Date start, Date end);
//    void logAirtelMoneyData();
//    void logGsmData();
}
