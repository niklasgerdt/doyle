
class person
{
  string name;
  int age;
public:
  person() : age(5) { }
  void setName(string name);
  void print() const;
};

void person::print() const
{
  cout << name << ":" << age << endl;
}

void person::setName(string _name){
	name = _name;
}