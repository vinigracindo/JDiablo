package br.ufal.lamp.diablo.tests.unit;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

		public static Test suite() {
			TestSuite suite = new TestSuite("All test for Diablo Project");
			suite.addTestSuite(TestJDiabloClass.class);
			suite.addTestSuite(TestBlock.class);
			suite.addTestSuite(TestDiagram.class);
			suite.addTestSuite(TestLineConnection.class);
			suite.addTestSuite(TestArquivoCC.class);
			suite.addTestSuite(TestGerador.class);
			suite.addTestSuite(TestArquivoPascal.class);
			return suite;
		}
		
}
