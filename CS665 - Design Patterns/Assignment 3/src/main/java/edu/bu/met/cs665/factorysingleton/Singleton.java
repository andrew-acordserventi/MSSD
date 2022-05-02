package edu.bu.met.cs665.factorysingleton;

/**
 * Singleton pattern. Ensures only one copy of the email/customer generation factory is made
 */
public class Singleton {

    private static CustomerGenerationFactory customerFactory;
    private static EMailGenerationFactory eMailGenerationFactory;

    private Singleton() {}

    public static synchronized CustomerGenerationFactory getInstanceCustomer() {
        if (customerFactory == null) {
            customerFactory = new CustomerGenerationFactory();
        }
        return customerFactory;
    }

    public static synchronized EMailGenerationFactory getInstanceEmail() {
        if (eMailGenerationFactory == null) {
            eMailGenerationFactory = new EMailGenerationFactory();
        }
        return eMailGenerationFactory;
    }
}
