����   4   3Maksim/Semenov/inb/ch/makery/address/model/SPersonM  java/lang/Object sfirstNamem &Ljavafx/beans/property/StringProperty; 
slastNamem sstreetm spostalCodem 'Ljavafx/beans/property/IntegerProperty; scitym 
sbirthdaym &Ljavafx/beans/property/ObjectProperty; 	Signature =Ljavafx/beans/property/ObjectProperty<Ljava/time/LocalDate;>; <init> ()V Code
     '(Ljava/lang/String;Ljava/lang/String;)V LineNumberTable LocalVariableTable this 5LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;
      *javafx/beans/property/SimpleStringProperty
      (Ljava/lang/String;)V	  "  	  $   & some street	  (   * +javafx/beans/property/SimpleIntegerProperty
 ) ,  - (I)V	  / 	 
 1 	some city	  3   5 *javafx/beans/property/SimpleObjectProperty
 7 9 8 java/time/LocalDate : ; of (III)Ljava/time/LocalDate;
 4 =  > (Ljava/lang/Object;)V	  @   	firstName Ljava/lang/String; lastName getFirstName ()Ljava/lang/String;
 G I H $javafx/beans/property/StringProperty J K get ()Ljava/lang/Object; M java/lang/String setFirstName
 G P Q > set firstNameProperty (()Ljavafx/beans/property/StringProperty; getLastName setLastName lastNameProperty 	getStreet 	setStreet street streetProperty getPostalCode ()I
 ^ ` _ %javafx/beans/property/IntegerProperty J \ setPostalCode
 ^ c Q - 
postalCode I postalCodeProperty )()Ljavafx/beans/property/IntegerProperty; getCity setCity city cityProperty getBirthday ()Ljava/time/LocalDate; RuntimeVisibleAnnotations 7Ljavax/xml/bind/annotation/adapters/XmlJavaTypeAdapter; value >LMaksim/Semenov/inb/ch/makery/address/util/SLocalDateAdapterM;
 s I t $javafx/beans/property/ObjectProperty setBirthday (Ljava/time/LocalDate;)V
 s P birthday Ljava/time/LocalDate; birthdayProperty (()Ljavafx/beans/property/ObjectProperty; ?()Ljavafx/beans/property/ObjectProperty<Ljava/time/LocalDate;>; 
SourceFile SPersonM.java !                      	 
                         5     *� �       
                          �     Y*� *� Y+� � !*� Y,� � #*� Y%� � '*� )Yҷ +� .*� Y0� � 2*� 4Y�� 6� <� ?�       "           )   7 ! D " X #         Y       Y A B    Y C B   D E     5     *� !� F� L�           &              N       A     	*� !+� O�       
    *  +        	       	 A B   R S     /     *� !�           .              T E     5     *� #� F� L�           2              U       A     	*� #+� O�       
    6  7        	       	 C B   V S     /     *� #�           :              W E     5     *� '� F� L�           >              X       A     	*� '+� O�       
    B  C        	       	 Y B   Z S     /     *� '�           F              [ \     2     *� .� ]�           J              a -     A     	*� .� b�       
    N  O        	       	 d e   f g     /     *� .�           R              h E     5     *� 2� F� L�           V              i       A     	*� 2+� O�       
    Z  [        	       	 j B   k S     /     *� 2�           ^              l m  n     o  pc q    5     *� ?� r� 7�           c              u v     A     	*� ?+� w�       
    g  h        	       	 x y   z {      |    /     *� ?�           k              }    ~