����   4 �  FMaksim/Semenov/inb/ch/makery/address/view/SPersonEditDialogControllerM  java/lang/Object firstNameField  Ljavafx/scene/control/TextField; RuntimeVisibleAnnotations Ljavafx/fxml/FXML; lastNameField streetField postalCodeField 	cityField birthdayField sdialogStagem Ljavafx/stage/Stage; spersonm 5LMaksim/Semenov/inb/ch/makery/address/model/SPersonM; sokClickedm Z <init> ()V Code
    	     LineNumberTable LocalVariableTable this HLMaksim/Semenov/inb/ch/makery/address/view/SPersonEditDialogControllerM; 
initialize setDialogStage (Ljavafx/stage/Stage;)V	  #   dialogStage 	setPerson 8(LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;)V	  (  	  *  
 , . - 3Maksim/Semenov/inb/ch/makery/address/model/SPersonM / 0 getFirstName ()Ljava/lang/String;
 2 4 3 javafx/scene/control/TextField 5 6 setText (Ljava/lang/String;)V	  8 	 
 , : ; 0 getLastName	  = 
 
 , ? @ 0 	getStreet	  B  
 , D E F getPostalCode ()I
 H J I java/lang/Integer K L toString (I)Ljava/lang/String;	  N  
 , P Q 0 getCity	  S  
 , U V W getBirthday ()Ljava/time/LocalDate;
 Y [ Z 4Maksim/Semenov/inb/ch/makery/address/util/SDateUtilM \ ] sformatM )(Ljava/time/LocalDate;)Ljava/lang/String; _ 
dd.mm.yyyy
 2 a b 6 setPromptText person isOkClicked ()Z handleOk
  h i e sisInputValidM
 2 k l 0 getText
 , n o 6 setFirstName
 , q r 6 setLastName
 , t u 6 	setStreet
 H w x y parseInt (Ljava/lang/String;)I
 , { | } setPostalCode (I)V
 ,  � 6 setCity
 Y � � � sparseM )(Ljava/lang/String;)Ljava/time/LocalDate;
 , � � � setBirthday (Ljava/time/LocalDate;)V
 � � � javafx/stage/Stage �  close StackMapTable handleCancel �  
 � � � java/lang/String � F length � java/lang/StringBuilder
 � � � � valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 � �  6 � No valid first name!

 � � � � append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 � � K 0 � No valid last name!
 � No valid street!
 � No valid postal code!
 � +No valid postal code (must be an integer)!
 � No valid city!
 � No valid birthday!

 Y � � � svalidDateM (Ljava/lang/String;)Z � .No valid birthday. Use the format dd.mm.yyyy!

 � � � org/controlsfx/dialog/Dialogs � � create !()Lorg/controlsfx/dialog/Dialogs; � Invalid Fields
 � � � � title 3(Ljava/lang/String;)Lorg/controlsfx/dialog/Dialogs; � Please correct invalid fields
 � � � � masthead
 � � � � message
 � � � � 	showError (()Lorg/controlsfx/control/action/Action; � java/lang/NumberFormatException errorMessage Ljava/lang/String; e !Ljava/lang/NumberFormatException; 
SourceFile !SPersonEditDialogControllerM.java !     	              	            
                                                                      <     
*� *� �              	         
                    +      �           #                !     >     *+� "�       
    &  '                $    % &     �     W*+� '*� )+� +� 1*� 7+� 9� 1*� <+� >� 1*� A+� C� G� 1*� M+� O� 1*� R+� T� X� 1*� R^� `�       & 	   *  ,  -  . & / 4 0 ? 1 M 2 V 3        W       W c    d e     /     *� �           6              f              �     n*� g� i*� '*� )� j� m*� '*� 7� j� p*� '*� <� j� s*� '*� A� j� v� z*� '*� M� j� ~*� '*� R� j� �� �*� *� "� ��       * 
   ;  <  = # > 1 ? B @ P A a C f D m F        n     �    � m  �              6     *� "� ��       
    J  K              i e    A    o�L*� )� j� *� )� j� �� � �Y+� �� ��� �� �L*� 7� j� *� 7� j� �� � �Y+� �� ��� �� �L*� <� j� *� <� j� �� � �Y+� �� ��� �� �L*� A� j� *� A� j� �� � �Y+� �� ��� �� �L� &*� A� j� vW� M� �Y+� �� ��� �� �L*� M� j� *� M� j� �� � �Y+� �� ��� �� �L*� R� j� *� R� j� �� � �Y+� �� ��� �� �L� $*� R� j� �� � �Y+� �� ��� �� �L+� �� �� ��� �Ŷ �+� ʶ �W�  � � � �     r    N  P  Q . S E T Y V p W � Z � [ � \ � _ � ` � a � e � f  i j+ k. l; mO qV rX u[ v` we xi ym z        o     l � �  �  � �  �    �  �M �   �    �