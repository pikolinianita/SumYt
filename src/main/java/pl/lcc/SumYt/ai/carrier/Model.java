package pl.lcc.SumYt.ai.carrier;



    //{
    //  "id": "llama3-8b-8192",
    //  "object": "model",
    //  "created": 1693721698,
    //  "owned_by": "Meta",
    //  "active": true,
    //  "context_window": 8192,
    //  "public_apps": null
    //}

    public class Model {
        private String id;
        private String object;
        private long created;
        private String ownedBy;
        private boolean active;
        private int contextWindow;
        private Object publicApps;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public long getCreated() {
            return created;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public String getOwnedBy() {
            return ownedBy;
        }

        public void setOwnedBy(String ownedBy) {
            this.ownedBy = ownedBy;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public int getContextWindow() {
            return contextWindow;
        }

        public void setContextWindow(int contextWindow) {
            this.contextWindow = contextWindow;
        }

        public Object getPublicApps() {
            return publicApps;
        }

        public void setPublicApps(Object publicApps) {
            this.publicApps = publicApps;
        }

        @Override
        public String toString() {
            return "Model{" +
                    "id='" + id + '\'' +
                    ", objectType='" + object + '\'' +
                    ", created=" + created +
                    ", ownedBy='" + ownedBy + '\'' +
                    ", active=" + active +
                    ", contextWindow=" + contextWindow +
                    ", publicApps=" + publicApps +
                    '}';
        }
    }
