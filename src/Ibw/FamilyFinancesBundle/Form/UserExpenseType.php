<?php

namespace Ibw\FamilyFinancesBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class UserExpenseType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
			->add('user', null , array('label' => 'Член семьи'))
            ->add('fund', null , array('label' => 'Фонд'))
            ->add('expense', null , array('label' => 'Тип расхода'))
            ->add('cost', null , array('label' => 'Сумма'))
            ->add('amount', null , array('label' => 'Количество'))
            ->add('description', null , array('label' => 'Описание'))
            ->add('is_active', null , array('label' => 'Активность'))
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Ibw\FamilyFinancesBundle\Entity\UserExpense'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'ibw_familyfinancesbundle_userexpense';
    }
}
