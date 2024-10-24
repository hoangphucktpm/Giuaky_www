package iuh.huynhhoangphuc_21036541_candidate.enums;

public enum Roles {
    ADMINISTRATION,
    STAFF,
    MANAGER,
    EXECUTIVE;

    public static Roles getRole(String role) {
        for (Roles r : Roles.values()) {
            if (r.toString().equals(role)) {
                return r;
            }
        }
        return null;
    }


}


