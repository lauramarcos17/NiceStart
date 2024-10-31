## APP NICESTART
## PRIMERA APP CREADA 

Este repositorio muestra avances en la APP-


Captura de la ***primera pantalla*** :

![login activity](img/img1.png)

Captura de la ***segunda pantalla*** :

![login activity](img/img3.png)

Esta pantalla contiene ACTION BAR.

Codigo para poner EL ACTION BAR:

![login activity](img/theme.jpg)



Captura de la ***pantalla principal*** :

Cuando doy al boton SIGN UP O CANCEL me lleva a esta pantalla.

![login activity](img/img2.png)

Creo otra pantalla para el perfil de la persona: 

-Añado nombre,foto y correo. 
![login activity](img/perfil.png)

El codigo para añadir foto, ponerla en forma circular es este:

![login activity](img/fotoperfil.jpg)


Añado nueva pantalla : ***Splash***

con su animación: 

![login activity](img/definitiva.png)


Codigo para meter un ***tipo a la animacion.***

```       
        TextView texto=findViewById(R.id.titulo);

        ImageView thunder=findViewById(R.id.animacion);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.escala);

   
        texto.startAnimation(myanim);
        thunder.startAnimation(myanim);
 ```



>This repository is licensed under
>[Creativecommons Org Licenses By Sa 4](http://creativecommons.org/licenses/by-sa/4.0/)