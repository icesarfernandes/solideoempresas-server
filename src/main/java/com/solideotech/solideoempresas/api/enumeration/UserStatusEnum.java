package com.solideotech.solideoempresas.api.enumeration;

public enum UserStatusEnum {
    ACTIVE("Ativo(a)"),
    INACTIVE("Inativo(a)");

    public final String label;

    UserStatusEnum(String label){ this.label = label; };
}
