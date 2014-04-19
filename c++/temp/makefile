
CC = g++
LD = g++
#Käännösasetukset
CXXFLAGS = -std=c++11x

NAME = Strategy
OBJ_DIR = obj 
SRC_DIR = src 

#Objektitiedostot
PROJEKTI = src/Strategy.o

#Oletuksena suoritetaan osio "softa"
all: softa

#Tiedot, mistä lähdekooditiedostoista objektitiedostot käännetään
src/Strategy.o: src/Strategy.cpp

#Kääntö
softa:
    g++ $(PROJEKTI) $(CXXFLAGS) -o ohjelma

#Clean, joka poistaa tarpeettomat objektitiedostot
clean:
    rm -f $(PROJEKTI)