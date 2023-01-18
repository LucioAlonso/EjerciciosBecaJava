class Rectangulo {
        private int alto;
        private int ancho;

        public Rectangulo(){
            alto = 9;
            ancho = 15;
        }
        //Sobrecargados
        public Rectangulo(int alto){
            this.alto = alto;
            ancho = 15;
        }

        public Rectangulo(int alto, int ancho){
            this.alto = alto;
            this.ancho = ancho;
        }

        //De copia
        public Rectangulo(Rectangulo r){
            this.alto = r.alto;
            this.ancho = r.ancho;
        }

        //Get
        public int getAlto(){
            return alto;
        }

        //Set
        public void setAncho(int ancho){
            this.ancho = ancho;
        }
        

        
        

        //toString
        @Override
        public String toString() {
            return "alto: "+alto +" ancho: "+ancho;
        }
    }