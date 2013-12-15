<?php

namespace Ibw\FamilyFinancesBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class UserType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('name',null,array('label' => 'Имя'))
			->add('password',null,array('label' => 'Пароль'))
            ->add('status',null,array('label' => 'Статус'))
            ->add('email')
            ->add('birthday', 'birthday', array(
			'input'  => 'datetime',
            'widget' => 'single_text',
			'label' => 'День рождения',
			'format' => 'yyyy-MM-dd'
			))
            ->add('userFunds',null,array('label' => 'Фонды'))
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Ibw\FamilyFinancesBundle\Entity\User'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'ibw_familyfinancesbundle_user';
    }
}
