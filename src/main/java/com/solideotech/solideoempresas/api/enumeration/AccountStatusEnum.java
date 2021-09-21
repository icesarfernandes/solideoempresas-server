package com.solideotech.solideoempresas.api.enumeration;

public enum AccountStatusEnum {
    PENDING("Pendente"),
    ACTIVE("Ativa"),
    INACTIVE("Inativa"),
    BLOCKED("Bloqueada"),
    EXPIRED("Expirada");

    public final String label;

    AccountStatusEnum(String label){ this.label = label; };

    public static boolean isActive(String status) {
        if (status == null) {
            return false;
        }
        return ACTIVE.toString().equalsIgnoreCase(status);
    }

    public static boolean isInactive(String status) {
        if (status == null) {
            return false;
        }
        return INACTIVE.toString().equalsIgnoreCase(status);
    }
}
