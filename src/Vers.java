class Vers {
    private String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public int numarCuvinte() {
        return vers.trim().isEmpty() ? 0 : vers.trim().split("\\s+").length;
    }

    public int numarVocale() {
        int count = 0;
        for (char c : vers.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public boolean seIncheieCu(String grupare) {
        return vers.endsWith(grupare);
    }

    public String getVers() {
        return vers;
    }

    public void setVers(String vers) {
        this.vers = vers;
    }
}