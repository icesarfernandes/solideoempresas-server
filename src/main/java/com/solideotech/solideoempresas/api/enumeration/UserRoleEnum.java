package com.solideotech.solideoempresas.api.enumeration;

public enum UserRoleEnum {
    ADMIN("Administrador"),
    MANAGER("Gerente"),
    MANAGER_FINANCIAL("Gerente Financeiro"),
    MANAGER_SALES("Gerente de Vendas"),
    MANAGER_HUMAN_RESOURCES("Gerente de Recursos Humanos"),
    MANAGER_IT("Gerente de Tecnologia da Informação"),
    FINANCIAL("Gerente Financeiro"),
    SALES("Gerente de Vendas"),
    HUMAN_RESOURCES("Gerente de Recursos Humanos"),
    IT("Gerente de Tecnologia da Informação");

    public final String label;

    UserRoleEnum(String label){ this.label = label; };
}
