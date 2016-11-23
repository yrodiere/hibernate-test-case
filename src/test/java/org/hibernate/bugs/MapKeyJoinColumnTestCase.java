package org.hibernate.bugs;

import org.hibernate.bugs.model.Employee;
import org.hibernate.bugs.model.JobTitle;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Test;

public class MapKeyJoinColumnTestCase extends BaseCoreFunctionalTestCase {

	@Override
	protected Class[] getAnnotatedClasses() {
		return new Class[] {
				Employee.class,
				JobTitle.class
		};
	}

	@Override
	protected String getBaseForMappings() {
		return "org/hibernate/test/";
	}

	@Override
	protected void configure(Configuration configuration) {
		super.configure( configuration );
		
		configuration.setProperty( AvailableSettings.SHOW_SQL, Boolean.TRUE.toString() );
		configuration.setProperty( AvailableSettings.FORMAT_SQL, Boolean.TRUE.toString() );
	}

	@Test
	public void test() {
		// Just to add a breakpoint and manually inspect the schema.
	}

}
