����   4�  .Maksim/Semenov/inb/ch/makery/address/SMainAppM  javafx/application/Application sprimaryStagem Ljavafx/stage/Stage; srootLayoutm  Ljavafx/scene/layout/BorderPane; spersonDatam #Ljavafx/collections/ObservableList; 	Signature ZLjavafx/collections/ObservableList<LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;>; <init> ()V Code
    
     javafx/collections/FXCollections   observableArrayList %()Ljavafx/collections/ObservableList;	   	 
  3Maksim/Semenov/inb/ch/makery/address/model/SPersonM  Hans  Muster
  !  " '(Ljava/lang/String;Ljava/lang/String;)V $ & % !javafx/collections/ObservableList ' ( add (Ljava/lang/Object;)Z * Ruth , Mueller . Heinz 0 Kurz 2 Cornelia 4 Meier 6 Werner 8 Meyer : Lydia < Kunz > Anna @ Best B Stefan D Martin LineNumberTable LocalVariableTable this 0LMaksim/Semenov/inb/ch/makery/address/SMainAppM; start (Ljavafx/stage/Stage;)V	  L   N 
AddressApp
 P R Q javafx/stage/Stage S T setTitle (Ljava/lang/String;)V
 P V W  getIcons Y javafx/scene/image/Image [ &file:resources/images/address-book.png
 X ]  T
  _ `  sinitRootLayoutM
  b c  sshowPersonOverviewM primaryStage f javafx/fxml/FXMLLoader
 e  i view/RootLayout.fxml
 k m l java/lang/Class n o getResource "(Ljava/lang/String;)Ljava/net/URL;
 e q r s setLocation (Ljava/net/URL;)V
 e u v w load ()Ljava/lang/Object; y javafx/scene/layout/BorderPane	  {   } javafx/scene/Scene
 |   � (Ljavafx/scene/Parent;)V
 P � � � setScene (Ljavafx/scene/Scene;)V
 e � � w getController � @Maksim/Semenov/inb/ch/makery/address/view/SRootLayoutControllerM
 � � � � 
setMainApp 3(LMaksim/Semenov/inb/ch/makery/address/SMainAppM;)V
 P � �  show
 � � � java/io/IOException �  printStackTrace
  � � � sgetPersonFilePathM ()Ljava/io/File;
  � � � sloadPersonDataFromFileM (Ljava/io/File;)V loader Ljavafx/fxml/FXMLLoader; scene Ljavafx/scene/Scene; 
controller BLMaksim/Semenov/inb/ch/makery/address/view/SRootLayoutControllerM; e Ljava/io/IOException; file Ljava/io/File; StackMapTable � java/io/File � view/PersonOverview.fxml � javafx/scene/layout/AnchorPane
 x � � � 	setCenter (Ljavafx/scene/Node;)V � DMaksim/Semenov/inb/ch/makery/address/view/SPersonOverviewControllerM
 � � sloaderm spersonOverviewm  Ljavafx/scene/layout/AnchorPane; FLMaksim/Semenov/inb/ch/makery/address/view/SPersonOverviewControllerM; showPersonEditDialog 8(LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;)Z � view/PersonEditDialog.fxml
 P  � Edit Person	 � � � javafx/stage/Modality � � WINDOW_MODAL Ljavafx/stage/Modality;
 P � � � initModality (Ljavafx/stage/Modality;)V
 P � � � 	initOwner (Ljavafx/stage/Window;)V � FMaksim/Semenov/inb/ch/makery/address/view/SPersonEditDialogControllerM
 � � � J setDialogStage
 � � � � 	setPerson 8(LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;)V
 P � �  showAndWait
 � � � � isOkClicked ()Z person 5LMaksim/Semenov/inb/ch/makery/address/model/SPersonM; spagem sdialogStagem sscenem HLMaksim/Semenov/inb/ch/makery/address/view/SPersonEditDialogControllerM; sgetPrimaryStagem ()Ljavafx/stage/Stage; getPersonData \()Ljavafx/collections/ObservableList<LMaksim/Semenov/inb/ch/makery/address/model/SPersonM;>; main ([Ljava/lang/String;)V
  � � � launch args [Ljava/lang/String;
 � � � java/util/prefs/Preferences � � userNodeForPackage 0(Ljava/lang/Class;)Ljava/util/prefs/Preferences; � filePath
 � � � � get 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 � ] sprefsm Ljava/util/prefs/Preferences; 
sfilePathm Ljava/lang/String; java/lang/String ssetPersonFilePathM
 � getPath ()Ljava/lang/String;
 �	
 " put java/lang/StringBuilder AddressApp - 
 ]
 � getName
 append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 toString
 � T remove >Maksim/Semenov/inb/ch/makery/address/model/SPersonListWrapperM
 "! javax/xml/bind/JAXBContext#$ newInstance 0([Ljava/lang/Class;)Ljavax/xml/bind/JAXBContext;
 &'( createUnmarshaller ()Ljavax/xml/bind/Unmarshaller;*,+ javax/xml/bind/Unmarshaller-. 	unmarshal "(Ljava/io/File;)Ljava/lang/Object; $01  clear
345 
getPersons ()Ljava/util/List; $789 addAll (Ljava/util/Collection;)Z
 ; �
=?> org/controlsfx/dialog/Dialogs@A create !()Lorg/controlsfx/dialog/Dialogs;C Error
=EFG title 3(Ljava/lang/String;)Lorg/controlsfx/dialog/Dialogs;I Could not load data from file:

=KLG masthead
=NOP showException =(Ljava/lang/Throwable;)Lorg/controlsfx/control/action/Action;R java/lang/Exception 	scontextm Ljavax/xml/bind/JAXBContext; summ Ljavax/xml/bind/Unmarshaller; 	swrapperm @LMaksim/Semenov/inb/ch/makery/address/model/SPersonListWrapperM; Ljava/lang/Exception; savePersonDataToFile
 \]^ createMarshaller ()Ljavax/xml/bind/Marshaller;` jaxb.formatted.output
bdc java/lang/Booleanef valueOf (Z)Ljava/lang/Boolean;hji javax/xml/bind/Marshallerkl setProperty '(Ljava/lang/String;Ljava/lang/Object;)V
 
opq 
setPersons (Ljava/util/List;)Vhstu marshal #(Ljava/lang/Object;Ljava/io/File;)Vw Could not save data to file:
 smm Ljavax/xml/bind/Marshaller; loadPersonDataFromFile1 sshowBirthdayStatisticsM} view/BirthdayStatistics.fxml Birthday Statistics� HMaksim/Semenov/inb/ch/makery/address/view/SBirthdayStatisticsControllerM
���q ssetPersonDataM dialogStage JLMaksim/Semenov/inb/ch/makery/address/view/SBirthdayStatisticsControllerM; 
SourceFile SMainAppM.java !                 	 
                   �*� *� � *� � Y�  � # W*� � Y)+�  � # W*� � Y-/�  � # W*� � Y13�  � # W*� � Y57�  � # W*� � Y9;�  � # W*� � Y=?�  � # W*� � YA3�  � # W*� � YC+�  � # W�    E   2    %  #  '   ( 5 ) J * _ + t , � - � . � / � 0 F       � G H    I J     u     -*+� K*� KM� O*� K� U� XYZ� \� # W*� ^*� a�    E       4  5  6 $ 8 ( : , ; F       - G H     - d    `          ]� eY� gL+h� j� p*+� t� x� z� |Y*� z� ~M*� K,� �+� �� �N-*� �*� K� �� L+� �*� �L+� *+� ��    F I �  E   B    ?  @  A  @  B  D * E 2 G : H ? J F K J L N O S P W Q \ S F   >    ] G H    > � �  *  � �  :  � �  J  � �  S 
 � �  �    � I ��  �  c      �     9� eY� gL+�� j� p+� t� �M*� z,� �+� �� �N-*� �� L+� ��    0 3 �  E   & 	   X  Y  Z  \ # ^ + _ 0 a 4 b 8 d F   4    9 G H    ( � �    � �  +  � �  4  � �  �    s �  � �    ;     u� eY� gM,�� j� p,� t� �N� PY� �:�� O� �� �*� K� ˻ |Y-� ~:� �,� �� �:� �+� �� �� ۬M,� ��    m n �  E   F    i  j  k  m $ n + o 3 p < q F r M t V u ] v c x h z n { o | s } F   R    u G H     u � �   f � �   S � �  $ J �   F ( � �  V  � �  o  � �  �    � n �  � �     /     *� K�    E       � F        G H    �       �    /     *� �    E       � F        G H   	 � �     3     *� �    E   
    �  � F        � �    � �     |     � �L+�� �M,� � �Y,� ���    E       �  �  �  �  � F         G H     � �    �   �    �  �  �     �     B� �M+� +,�+��*� K�Y�+���� O� ,��*� KM� O�    E   "    �  � 
 �  � / � 2 � 8 � A � F        B G H     B � �   < � �  �   	 � 2 �  � �         f� kYS�M,�%N-+�) �:*� �/ *� �2�6 W*+�:� )M�<B�D�YH�+����J,�MW�    < ?Q  E   6    �  �  �  �  � ( � 7 � < � @ � C � I � ` � e � F   >    f G H     f � �   .ST   )UV   WX  @ % �Y  �    Q% Z �         j� kYS�M,�[N-_�a�g �Y�m:*� �n-+�r *+�:� )M�<B�D�Yv�+����J,�MW�    @ CQ  E   6    �  �  �  �   � ) � 2 � ; � @ � D � M � d � i � F   >    j G H     j � �   2ST   -xy  ) WX  D % �Y  �   	 � CQ% z �     5      �    E       � F        G H      � �  {          i� eY� gL+|� j� p+� t� �M� PY� �N-~� O-� �� �-*� K� ˻ |Y,� ~:-� �+� ���:*� ��-� �� L+� ��    ` c �  E   >    �  �  �  � $ � + � 2 � : � D � J � S � \ � ` � d � h � F   H    i G H    X � �   D � �  $ <�   D  � �  S  ��  d  � �  �   	 � c � �   �