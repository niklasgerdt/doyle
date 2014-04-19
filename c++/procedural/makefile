CC = g++
LD = g++

NAME = Strategy
OBJ_DIR = obj 
SRC_DIR = src 

CXX_FLAGS = -std=c++11x

SRC = $(shell find $(SRC_DIR) -type f -regex ".*\.cpp")
OBJ = $(subst $(SRC_DIR), $(OBJ_DIR), $(addsuffix .o, $(basename $(SRC))))

all: $(NAME)

$(NAME): $(OBJ)
	$(LD) -c $< -o $@ $(CXX_FLAGS)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.cpp
    $(CC) -c $< -o $@ $(CXX_FLAGS)

clean:
	rm $(NAME) $(OBJ_DIR) -rf