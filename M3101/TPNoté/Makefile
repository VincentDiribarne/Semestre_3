INC=-I . -I libIPC
LIB=-L libIPC -lIPC -lpthread
LD=gcc -o
CC=gcc -c

TARGET=initRessources deleteRessources superviseur mkProdCons producteur consommateur
OBJ=$(patsubst %, %.o, $(TARGET))

all: $(TARGET)

$(TARGET): % : %.o
	$(LD) $@ $^ $(LIB)

$(OBJ): %.o : %.c types.h
	$(CC) $< $(INC)

clean:
	rm $(TARGET) $(OBJ)

