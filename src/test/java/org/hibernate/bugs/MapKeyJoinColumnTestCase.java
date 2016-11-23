package org.hibernate.bugs;

import org.hibernate.bugs.model.Employee;
import org.hibernate.bugs.model.JobTitle;
import org.hibernate.bugs.util.SchemaUtil;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.hibernate.tool.util.MetadataHelper;
import org.junit.Assert;
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
	protected void configure(Configuration configuration) {
		super.configure( configuration );
		
		configuration.setProperty( AvailableSettings.SHOW_SQL, Boolean.TRUE.toString() );
		configuration.setProperty( AvailableSettings.FORMAT_SQL, Boolean.TRUE.toString() );
	}

	@Test
	public void test() {
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"employee_informationbefore_experiences",
						"jobtitle_id",
						MetadataHelper.getMetadata(configuration())
				)
		);
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"employee_informationbefore_experiences",
						"details",
						MetadataHelper.getMetadata(configuration())
				)
		);
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"employee_informationafter_experiences",
						"jobtitle_id",
						MetadataHelper.getMetadata(configuration())
				)
		);
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"employee_informationafter_experiences",
						"details",
						MetadataHelper.getMetadata(configuration())
				)
		);
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"Employee_experiences",
						"jobtitle_id",
						MetadataHelper.getMetadata(configuration())
				)
		);
		Assert.assertTrue(
				SchemaUtil.isColumnPresent(
						"Employee_experiences",
						"details",
						MetadataHelper.getMetadata(configuration())
				)
		);
	}

}
