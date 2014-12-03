package com.cycle7.remindme.roboguice.bindingmodule;
import com.cycle7.remindme.database.DatabaseHandler;
import com.cycle7.remindme.database.IDatabaseHandler;
import com.cycle7.remindme.services.implementations.BillService;
import com.cycle7.remindme.services.implementations.DateService;
import com.cycle7.remindme.services.interfaces.IBillService;
import com.cycle7.remindme.services.interfaces.IDateService;
import com.google.inject.AbstractModule;

public class BindingModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(IBillService.class).to(BillService.class);
		bind(IDatabaseHandler.class).to(DatabaseHandler.class);
		bind(IDateService.class).to(DateService.class);
	}
}
