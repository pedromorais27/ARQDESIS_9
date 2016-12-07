package br.com.usjt.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConnectionFactoryTest.class, ContaDAOTest.class, ContaTest.class, ContaTOTest.class,
		SaqueTest.class, SaqueTOTest.class, DispenserTOTest.class, DispenserTest.class, DispenserTOTest.class})
public class AllTests {

}