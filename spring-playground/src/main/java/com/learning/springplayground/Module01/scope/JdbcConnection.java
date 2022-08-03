package com.learning.springplayground.Module01.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {
    public JdbcConnection() {
        System.out.println("JDBC Connection");
    }
}

// The line @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
// Here Person DAO by default gets Singleton Scope
// JdbcConnection class will have prototype scope with scoped with TARGET_CLASS as ScopedProxyMode which will help
// return new instance of JdbcConnection for same PersonDAO instance. Example:

// Output from personDAO and personDAO.getJdbcConnection
// com.learning.springplayground.Module01.scope.PersonDAO@6e35bc3d          -- SAME
// com.learning.springplayground.Module01.scope.JdbcConnection@63dd899      -- DIFFERENT

// Output from personDAO2 and personDAO2.getJdbcConnection
// com.learning.springplayground.Module01.scope.PersonDAO@6e35bc3d          -- SAME
// com.learning.springplayground.Module01.scope.JdbcConnection@59d2400d     -- DIFFERENT

// Here we get benefit where one personDAO instance will create multiple instance of JdbcConnection
// Otherwise in order to achieve similar result we need different instance of personDAO to obtain different instance of JdbcConnection
// Which will result in 4 objects in total. But in this case we have 3 in total
// Note: Increase in number of objects results in increase memory usage and garbage collection time
