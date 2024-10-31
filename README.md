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
-Añado nombre,foto y su correo 
![login activity](img/perfil.png)

El codigo para añadir foto, ponerla en forma circular es este:
![login activity](img/fotoperfil.jpg)


Añado nueva pantalla : ***Splash***
con su animacion: 

![login activity](img/definitiva.png)

Codigo para meter un tipo a la animacion.

```       
        TextView texto=findViewById(R.id.titulo);

        ImageView thunder=findViewById(R.id.animacion);
        
        //aqui creo objeto animacion descrita en xml llamada blink
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.escala);

        //NO HACE FALTA CREAR OTRA ANIMACION SI QUIERO HACER LO MISMO EN LAS DOS
        
        Animation myanimtexto=AnimationUtils.loadAnimation(this,R.anim.escala);
        texto.startAnimation(myanim);
        
        //con este metodo startanimation lo aplicamos al imagenview del logo
        thunder.startAnimation(myanim);
 ```



>This repository is licensed under
>[Creativecommons Org Licenses By Sa 4](http://creativecommons.org/licenses/by-sa/4.0/)