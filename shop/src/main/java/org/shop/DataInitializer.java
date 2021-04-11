package org.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * The main Data Initializer util class.
 */
public class DataInitializer {

    /** The seller initializer. */
    @Autowired
    @Qualifier("sellerInitializer")
    private SellerInitializer sellerInitializer;
    
    /** The product initializer. */
    @Autowired
    @Qualifier("productInitializer")
    private ProductInitializer productInitializer;
    
    /** The proposal initializer. */
    @Autowired
    @Qualifier("proposalInitializer")
    private ProposalInitializer proposalInitializer;
    
    /** The user initializer. */
    @Autowired
    @Qualifier("userInitializer")
    private UserInitializer userInitializer;

    /**
     * Inits the data.
     */
    public void initData() {
        sellerInitializer.initSellers();
        userInitializer.initUsers();
        productInitializer.initProducts();
        proposalInitializer.initProposals();
    }
}
