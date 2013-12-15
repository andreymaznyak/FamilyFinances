<?php

namespace Ibw\FamilyFinancesBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Ibw\FamilyFinancesBundle\Entity\Income;
use Ibw\FamilyFinancesBundle\Form\IncomeType;

/**
 * Income controller.
 *
 */
class IncomeController extends Controller
{

    /**
     * Lists all Income entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('IbwFamilyFinancesBundle:Income')->findAll();

        return $this->render('IbwFamilyFinancesBundle:Income:index.html.twig', array(
            'entities' => $entities,
        ));
    }
    /**
     * Creates a new Income entity.
     *
     */
    public function createAction(Request $request)
    {
        $entity = new Income();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('income_show', array('id' => $entity->getId())));
        }

        return $this->render('IbwFamilyFinancesBundle:Income:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
    * Creates a form to create a Income entity.
    *
    * @param Income $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createCreateForm(Income $entity)
    {
        $form = $this->createForm(new IncomeType(), $entity, array(
            'action' => $this->generateUrl('income_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Income entity.
     *
     */
    public function newAction()
    {
        $entity = new Income();
        $form   = $this->createCreateForm($entity);

        return $this->render('IbwFamilyFinancesBundle:Income:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Finds and displays a Income entity.
     *
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Income')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Income entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('IbwFamilyFinancesBundle:Income:show.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),        ));
    }

    /**
     * Displays a form to edit an existing Income entity.
     *
     */
    public function editAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Income')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Income entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('IbwFamilyFinancesBundle:Income:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
    * Creates a form to edit a Income entity.
    *
    * @param Income $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createEditForm(Income $entity)
    {
        $form = $this->createForm(new IncomeType(), $entity, array(
            'action' => $this->generateUrl('income_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }
    /**
     * Edits an existing Income entity.
     *
     */
    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Income')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Income entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('income_edit', array('id' => $id)));
        }

        return $this->render('IbwFamilyFinancesBundle:Income:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Deletes a Income entity.
     *
     */
    public function deleteAction(Request $request, $id)
    {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('IbwFamilyFinancesBundle:Income')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Income entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('income'));
    }

    /**
     * Creates a form to delete a Income entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('income_delete', array('id' => $id)))
            ->setMethod('DELETE')
            ->add('submit', 'submit', array('label' => 'Delete'))
            ->getForm()
        ;
    }
}
