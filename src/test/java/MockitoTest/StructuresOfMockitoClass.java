package MockitoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StructuresOfMockitoClass {

	/*
	 * The code marked @Before is executed before each test, while @BeforeClass
	 * runs once before the entire test fixture. If your test class has ten
	 * tests, @Before code will be executed ten times, but @BeforeClass will be
	 * executed only once.
	 * 
	 * In general, you use @BeforeClass when multiple tests need to share the
	 * same computationally expensive setup code. Establishing a database
	 * connection falls into this category. You can move code from @BeforeClass
	 * into @Before, but your test run may take longer. Note that the code
	 * marked @BeforeClass is run as static initializer, therefore it will run
	 * before the class instance of your test fixture is created.
	 * 
	 * In JUnit 5, the tags @BeforeEach and @BeforeAll are the equivalents
	 * of @Before and @BeforeClass in JUnit 4. Their names are a bit more
	 * indicative of when they run, loosely interpreted: 'before each tests' and
	 * 'once before all tests'.
	 */

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class, run 1 one before instance of Class, setup a sthing common for all test. Using for setup connection DB ");
	}

	@Before
	public void setUp() {
		System.out.println("Prepare something here for mockito. Run more time when test run .");
	}

	@Test
	public void test() {
		assertTrue("mockito success", true);
	}

	@After
	public void after() {
		System.out.println("Do something after mockito success. Same same @Before anotation");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class : setup value of variable. Same same @BeforeClass anotation");
	}

}
