package com.platform.configure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.platform.configure.entry.Country;
import com.platform.configure.entry.TimeZone;

public class ResourceReader {
	private static Logger logger = LoggerFactory.getLogger(ResourceReader.class);
	private final static String SEPARATOR = File.separator;
	private static InputStream contryInputStream = null;
	private static InputStream timezoneInputStream = null;
	public static List<Country> countryGlobalList = new ArrayList<Country>();
	public static List<TimeZone> timeZoneGlobalList = new ArrayList<TimeZone>();
	static {
		SAXReader reader = new SAXReader();
		Document countryDoc = null;
		Document timezoneDoc = null;
		contryInputStream = ResourceReader.class.getClassLoader().getResourceAsStream(SEPARATOR + "configure" + SEPARATOR + "country.xml");
		timezoneInputStream = ResourceReader.class.getClassLoader().getResourceAsStream(SEPARATOR + "configure" + SEPARATOR + "timezone.xml");
		try {
			countryDoc = reader.read(contryInputStream);
			timezoneDoc = reader.read(timezoneInputStream);
			Element countrysRoot = countryDoc.getRootElement();
			Iterator<Element> countrysIter = countrysRoot.elementIterator();
			Element countryElement = null;
			Iterator<Element> propertiesIter = null;
			Element propertiesElement = null;
			Country country = null;
			while (countrysIter.hasNext()) {
				countryElement = countrysIter.next();
				country = new Country();
				propertiesIter = countryElement.elementIterator();
				while (propertiesIter.hasNext()) {
					propertiesElement = propertiesIter.next();
					if (propertiesElement.getName().equals("cnName")) {
						country.setCnName(propertiesElement.getStringValue().trim());
					}
					if (propertiesElement.getName().equals("enName")) {
						country.setEnName(propertiesElement.getStringValue().trim());
					}
					if (propertiesElement.getName().equals("enFullName")) {
						country.setEnFullName(propertiesElement.getStringValue().trim());
					}
					if (propertiesElement.getName().equals("code")) {
						country.setCode(propertiesElement.getStringValue().trim());
					}
					if (propertiesElement.getName().equals("codeThree")) {
						country.setCodeThree(propertiesElement.getStringValue().trim());
					}
					if (propertiesElement.getName().equals("tel")) {
						country.setTel(propertiesElement.getStringValue().trim());
					}
				}
				countryGlobalList.add(country);
			}
			Element timeZoneRoot = timezoneDoc.getRootElement();
			Iterator<Element> timezonesIter = timeZoneRoot.elementIterator();
			Element timeZonesElement = null;
			Iterator<Element> timeZoneElementIter = null;
			Element timeZoneElement = null;
			TimeZone timeZone = null;
			while (timezonesIter.hasNext()) {
				timeZone = new TimeZone();
				timeZonesElement = timezonesIter.next();
				timeZoneElementIter = timeZonesElement.elementIterator();
				List<Country> countryList = new ArrayList<Country>();
				while (timeZoneElementIter.hasNext()) {
					timeZoneElement = timeZoneElementIter.next();
					if (timeZoneElement.getName().equals("utc")) {
						timeZone.setUtc(timeZoneElement.getStringValue());
					}
					if (timeZoneElement.getName().equals("GMT")) {
						timeZone.setGmt(timeZoneElement.getStringValue());
					}
					if (timeZoneElement.getName().equals("countrys")) {
						Iterator<Element> contrysIter = timeZoneElement.elementIterator();
						Country timeZoneCountry = null;
						while (contrysIter.hasNext()) {
							Element timeZoneContryElement = contrysIter.next();
							timeZoneCountry = new Country();
							if (timeZoneContryElement.getName().equals("country")) {
								for (int m = 0; m < countryGlobalList.size(); m++) {
									Country temp=countryGlobalList.get(m);
									if (timeZoneContryElement.getStringValue().equals(temp.getEnName())) {
										timeZoneContryElement.addAttribute("code", temp.getCode());
										timeZoneContryElement.addAttribute("codeThree", temp.getCodeThree());
										timeZoneCountry.setCode(temp.getCode());
										timeZoneCountry.setCodeThree(temp.getCodeThree());
									}
								}
								timeZoneCountry.setEnName(timeZoneContryElement.getStringValue());
								countryList.add(timeZoneCountry);
							}
						}
						timeZone.setCountryList(countryList);
					}
				}
				timeZoneGlobalList.add(timeZone);
			}
		} catch (DocumentException e) {
			logger.error("ResourceReader>DocumentException:" + e);
		} finally {
			if (null != contryInputStream) {
				try {
					contryInputStream.close();
				} catch (IOException e) {
					logger.error("ResourceReader>finally>contryInputStream:" + e);
				}
			}
			if (null != timezoneInputStream) {
				try {
					timezoneInputStream.close();
				} catch (IOException e) {
					logger.error("ResourceReader>finally>timezoneInputStream:" + e);
				}
			}
		}
	}
}
